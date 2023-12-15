@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
    page = page,
    content = @`
        <h2>Posts</h2>

        @for(var post : page.getPosts())
            <div>
                <h3>${post.getName()}</h3>
                <p>${post.getBody()}</p>
            </div>
        @endfor
    `
)