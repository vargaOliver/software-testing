package uni.sw.unit.testing;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doThrow;

public class UserTest {

    @Test   
    public void testDefaultUser(){
        System.out.println("Testing default user");

        User user = new User();

        assertNotNull(user, "user object shouldn't be null");
        assertNull(user.getUserName(), "username should be null");
        assertNull(user.getPassword(), "password should be null");
        assertEquals(0, user.getId(), "id should be 0");
        assertThrows(UnsupportedOperationException.class, user::isLoggedIn, "method should throw UnsupportedOperationException");
    }

    @Test
    //@ExtendWith(MockitoExtension.class)
    public void testMockUser(){
        System.out.println("Testing mock user");

        User user = mock(User.class);

        when(user.getId()).thenReturn(1);
        assertEquals(1, user.getId(), "id should be 1");

        when(user.getUserName()).thenReturn("teszt");
        assertEquals("teszt", user.getUserName(), "username should be teszt");

        when(user.getPassword()).thenReturn("asd123");
        assertEquals("asd123", user.getPassword(), "password should be asd123");
        assertEquals(6, user.getPassword().length(), "password length should be 6");

        doThrow(new UnsupportedOperationException()).when(user).isLoggedIn();
        assertThrows(UnsupportedOperationException.class, user::isLoggedIn, "method should throw UnsupportedOperationException");

        when(user.getAcademicAverage(anyInt())).thenReturn(4.6);
        assertEquals(4.6, user.getAcademicAverage(2));
        assertEquals(4.6, user.getAcademicAverage(3));

        doThrow(new UnsupportedOperationException()).when(user).update(anyString(), anyBoolean());
        assertThrows(UnsupportedOperationException.class, () -> {
            user.update("x", true);
        }, "method should throw UnsupportedOperationException");

        verify(user).getUserName();
        verify(user, times(2)).getPassword();
        verify(user).getId();
        verify(user).isLoggedIn();
        verify(user, times(2)).getAcademicAverage(anyInt());
        verify(user).update(anyString(), anyBoolean());
    }

}

