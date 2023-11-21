@import exercise.dto.users.UsersPage
@param UsersPage usersPage

<html lang="en">
    <head>
        <title>Hexlet</title>
    </head>
    <body>
        <main>
            <h1>Users</h1>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>E-mail</th>
                </tr>
                @for(var user : usersPage.getUsers())
                    <tr>
                        <td>${user.getId()}</td>
                        <td>
                            <a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a>
                        </td>
                        <td>${user.getEmail()}</td>
                    </tr>
                @endfor
            </table>
        </main>
    </body>
</html>
