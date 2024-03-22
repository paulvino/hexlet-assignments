package exercise.controller.users;

import java.net.URI;
import java.util.List;
import org.springframework.http.HttpStatus;

import exercise.model.Post;
import exercise.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// BEGIN
@RestController
@RequestMapping("/api")
public class PostsController {
    private List<Post> posts = Data.getPosts();

    @GetMapping("/users/{userId}/posts")
    public List<Post> show(
            /*@RequestParam(defaultValue = "1") long page,
            @RequestParam(defaultValue = "10") Integer limit,
            @RequestBody Post post, */
            @PathVariable Integer userId) {
//        var result = posts.stream()
//                .filter(post -> post.getUserId() == id)
//                .skip((page - 1) * limit)
//                .limit(limit)
//                .toList();
//
//        return ResponseEntity.ok(result);
        return posts.stream()
                .filter(p -> p.getUserId() == userId).toList();
    }

    @PostMapping("/users/{userId}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@PathVariable Integer userId, @RequestBody Post post) {
        post.setUserId(userId);
        posts.add(post);
        return post;
    }
}
// END