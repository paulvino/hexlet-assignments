@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(
    content = @`
        @for(var post : page.getPosts())
            <a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
        @endfor
        <a href="${NamedRoutes.postsPath()}?page=${page.getPage() - 1}">Previous page</a>
        <a href="${NamedRoutes.postsPath()}?page=${page.getPage() + 1}">Next page</a>
    `
)