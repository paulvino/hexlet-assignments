package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// BEGIN
class Validator {
    public static List<String> validate(Object obj) {
        List<String> result = new ArrayList<>();
        Field[] declaredFields = obj.getClass().getDeclaredFields();

        try {
            for (Field field : declaredFields) {
                field.setAccessible(true);
                boolean isAnnotated = field.isAnnotationPresent(NotNull.class);
                if (isAnnotated && field.get(obj) == null) {
                    result.add(field.getName());
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {

        Map<String, List<String>> result = new LinkedHashMap<>();

        try {
            Field[] declaredFields = address.getClass().getDeclaredFields();
            for (Field field: declaredFields) {
                field.setAccessible(true);

                List<String> violations = new ArrayList<>();

                boolean isAnnotatedNotNull = field.isAnnotationPresent(NotNull.class);
                boolean isAnnotatedMinLength = field.isAnnotationPresent(MinLength.class);

                String fieldName = field.getName();

                if (isAnnotatedNotNull && field.get(address) == null) {
                    violations.add("can not be null");
                }

//                value of "java.lang.reflect.Field.get(Object)" is null!!!
//                int length = field.get(address).toString().length();

                if (isAnnotatedMinLength
                        && field.get(address).toString().length()
                        < field.getAnnotation(MinLength.class).minLength()) {
                    int minLength = field.getAnnotation(MinLength.class).minLength();
                    violations.add("length less than " + minLength);
                }

                if (!violations.isEmpty()) {
                    result.put(fieldName, violations);
                }
            }
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }

        return result;
    }
}
// END
