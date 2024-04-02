package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// BEGIN
@RestController
@RequestMapping(path = "/posts")
public class PostsController {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "")
    public List<PostDTO> index() {
        var posts = postRepository.findAll();
        var result = posts.stream()
                .map(this::toPostDTO)
                .toList();
        return result;
    }

    @GetMapping(path = "/{id}")
    public PostDTO show(@PathVariable long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));

        return toPostDTO(post);
    }

    private PostDTO toPostDTO(Post post) {
        var dto = new PostDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setBody(post.getBody());
        var comments = commentRepository.findByPostId(post.getId());
        var commentsDTO = comments.stream()
                .map((comment) -> {
                    var commentDTO = new CommentDTO();
                    commentDTO.setBody(comment.getBody());
                    commentDTO.setId(comment.getId());
                    return commentDTO;
                })
                .toList();
        dto.setComments(commentsDTO);
        return dto;
    }

//    private PostDTO toPostDTO(Post post) {
//        var dto = new PostDTO();
//
//        dto.setId(post.getId());
//        dto.setTitle(post.getTitle());
//        dto.setBody(post.getBody());
//
//        return dto;
//    }
//
//    private CommentDTO toCommentDTO(Comment comment) {
//        var dto = new CommentDTO();
//
//        dto.setId(comment.getId());
//        dto.setBody(comment.getBody());
//
//        return dto;
//    }
}
// END
