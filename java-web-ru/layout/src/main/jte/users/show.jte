@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
    content = @`
        <h2>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h2>
        <p>User ID: ${page.getUser().getId()}</p>
        <p>User e-mail: ${page.getUser().getEmail()}</p>
    `,
    footer = @`
        <a href="https://github.com/paulvino">My GitHub profile</a>
    `
)
