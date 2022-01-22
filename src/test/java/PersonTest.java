import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class PersonTest {

    @Test
    void whenListToStreamAndBackToList_thenReferencesAreTheSame() {
        Person before = new Person("Grace Hopper");
        List<Person> persons = Stream.of(before).collect(Collectors.toList());
        Person after = persons.get(0);

        before.setName("Grace Murray Hopper");
        assertThat(after.getName()).isEqualTo("Grace Murray Hopper");
    }

    @Test
    void whenUseCopyConstructor_thenReferenceNotTheSame() {
        Person before = new Person("Grace Hopper");
        List<Person> persons = Stream.of(before).map(Person::new).collect(Collectors.toList());
        Person after = persons.get(0);
        assertNotSame(before, after);
        assertThat(after).isEqualTo(before);

        before.setName("Rear Admiral Dr. Grace Murray Hopper");
        assertNotEquals(before, after);
    }
}
