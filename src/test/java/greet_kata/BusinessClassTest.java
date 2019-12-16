package greet_kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class BusinessClassTest {

    BusinessClass businessClass;
    @Mock
    NameAsker nameAsker;

    @BeforeEach
    void setUp() {
        businessClass = new BusinessClass(nameAsker);
    }

    @Test
    @DisplayName("Greeting for name")
    void greet_shouldReturnProperGreetingForName() {
        Mockito.when(nameAsker.askName()).thenReturn(new String[]{"Jan"});
        assertThat(businessClass.greet()).isEqualTo("Hello, Jan.");
    }

    @Test
    @DisplayName("Greeting for null")
    void greet_shouldReturnProperGreetingForNull() {
        Mockito.when(nameAsker.askName()).thenReturn(new String[]{null});
        assertThat(businessClass.greet()).isEqualTo("Hello, my friend.");
    }

    @Test
    @DisplayName("GREETING FOR UPPERCASE NAME")
    void greet_shouldReturnProperGreetingForUpperCase() {
        Mockito.when(nameAsker.askName()).thenReturn(new String[]{"JANE"});
        assertThat(businessClass.greet()).isEqualTo("HELLO JANE!");
    }

    @Test
    @DisplayName("Greeting for Two names")
    void greet_shouldReturnProperGreetingForTwoFriends() {
        Mockito.when(nameAsker.askName()).thenReturn(new String[]{"Jill", "Jane"});
        assertThat(businessClass.greet()).isEqualTo("Hello, Jill and Jane.");
    }

    @Test
    @DisplayName("Greeting for Multiple names")
    void greet_shouldReturnProperGreetingForMultipleFriends() {
        Mockito.when(nameAsker.askName()).thenReturn(new String[]{"Amy", "Brian", "Charlotte"});
        assertThat(businessClass.greet()).isEqualTo("Hello, Amy, Brian, and Charlotte.");
    }

    @Test
    @DisplayName("Greeting for MIxEd InSeRtEd NaMeS")
    void greet_shouldReturnProperGreetingForMIxEdInSeRtEdNaMeS() {
        Mockito.when(nameAsker.askName()).thenReturn(new String[]{"Amy", "Charlotte", "BRIAN"});
        assertThat(businessClass.greet()).isEqualTo("Hello, Amy and Charlotte. AND HELLO BRIAN!");
    }

    @Test
    @DisplayName("Greeting for comas")
    void greet_shouldReturnProperGreetingForComas() {
        Mockito.when(nameAsker.askName()).thenReturn(new String[]{"Bob", "Charlie, Dianne"});
        assertThat(businessClass.greet()).isEqualTo("Hello, Bob, Charlie, and Dianne.");
    }

    @Test
    @DisplayName("Greeting for stupid friends")
    void greet_shouldReturnProperGreetingForStupidFriends() {
        Mockito.when(nameAsker.askName()).thenReturn(new String[]{"Bob", "\"Charlie, Dianne\""});
        assertThat(businessClass.greet()).isEqualTo("Hello, Bob and Charlie, Dianne.");
    }
}
