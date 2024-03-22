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

    @GetMapping("/users/{id}/posts")
    public ResponseEntity<List<Post>> index(
            @RequestParam(defaultValue = "1") long page,
            @RequestParam(defaultValue = "10") Integer limit,
            @PathVariable int id) {
        var result = posts.stream()
                .filter(post -> post.getUserId() == id)
                .skip((page - 1) * limit)
                .limit(limit)
                .toList();

        return ResponseEntity.ok(result);
    }

    @PostMapping("/users/{id}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Post> create(
            @PathVariable int id,
            @RequestBody Post post) {
        post.setUserId(id);
        posts.add(post);
        return ResponseEntity.created(URI.create("/users/" + id + "/posts")).body(post);
    }
}
// END