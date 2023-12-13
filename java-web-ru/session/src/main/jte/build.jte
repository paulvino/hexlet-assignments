@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes
@param LoginPage page

@template.layout.page(
    content = @`
        @if(page.getError() != null)
            ${page.getError()}
        @endif

        <form action="${NamedRoutes.loginPath()}" method="post">
            <div>
                <label>
                    Enter your name
                    <input type="text" name="name" required value="${page.getName()}" />
                </label>
                <label>
                    Enter your password
                    <input type="password" name="password" />
                </label>
                <input type="submit" name="Confirm">
            </div>
        </form>
    `
)