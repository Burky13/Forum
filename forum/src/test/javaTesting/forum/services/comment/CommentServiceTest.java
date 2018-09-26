package forum.services.comment;

import java.util.ArrayList;
import java.util.List;

import forum.entity.Comment;
import forum.entity.Theme;
import forum.entity.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import java.lang.NullPointerException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.soap.Text;
import java.util.Date;
import java.lang.String;
import java.lang.Object;
import java.lang.Throwable;
import java.lang.Exception;
import java.lang.RuntimeException;
import org.springframework.context.NoSuchMessageException;

public class CommentServiceTest {

    @Autowired
    private CommentService commentService;

        Comment c = new Comment();

        Theme t = new Theme();
        User Marek = new User();
        String text = "Auto...";
        Date d = new Date();

        @Test
        public void testAddComment() throws InterruptedException {

            c.setTheme(t);
            c.setUser(Marek);
            c.setText(text);
            c.setDate(d);


            List<Comment> CommentsBeforeAdd = new ArrayList<>(); //Mal by vypisat  a skontrolovat tabulku s komentarmi pred pridanim noveho komentara.
            CommentsBeforeAdd = commentService.getAllComments();
            commentService.addComment(c);

            List<Comment> CommentsAfterAdd = new ArrayList<>(); //Mal by vypisat a skontrolovat tabulku s komentarmi po pridani noveho komentara.
            CommentsAfterAdd = commentService.getAllComments();
            Assert.assertEquals(CommentsBeforeAdd.size() + 1, CommentsAfterAdd);
        }

        @Test
        public void testRemoveComment() {

            c.setTheme(t);
            c.setUser(Marek);
            c.setText(text);
            c.setDate(d);

            List<Comment> CommentsBeforeRemove = new ArrayList<>(); //Mal by vypisat  a skontrolovat tabulku s komentarmi pred odobranim noveho komentara.
            CommentsBeforeRemove = commentService.getAllComments();
            commentService.removeComment(c.getId());

            List<Comment> CommentsAfterRemove = new ArrayList<>(); //Mal by vypisat a skontrolovat tabulku s komentarmi po odobrani noveho komentara.
            CommentsAfterRemove = commentService.getAllComments();
            Assert.assertEquals(CommentsBeforeRemove.size() - 1, CommentsAfterRemove);

        }

        @Test
        public void testGetComments() {

            c.getTheme();
            c.getUser();
            c.getText();
            c.getDate();
            c.getId();


        }

        @Test
        public void testEditComment() {

        }
    }


