@import exercise.dto.users.UserPage
@param UserPage userPage

<html lang="en">
    <head>
        <title>Hexlet</title>
    </head>
    <body>
    <main>
        <h1>User</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>E-mail</th>
            </tr>
            <tr>
                <td>${userPage.getUser().getId()}</td>
                <td>${userPage.getUser().getFirstName()} ${userPage.getUser().getLastName()}</td>
                <td>${userPage.getUser().getEmail()}</td>
            </tr>
        </table>
    </main>
    </body>
</html>>