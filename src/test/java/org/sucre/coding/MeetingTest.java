package org.sucre.coding;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MeetingTestTemplateInvocationContextProvider.class)
class MeetingTest {

    @TestTemplate
    void testMeetingTypeContextProvider(Meeting meeting) {
        assertTrue(Arrays.asList(MeetingType.values()).contains(meeting.meetingType()));
    }
}
