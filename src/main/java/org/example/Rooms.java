package org.example;

import java.util.Random;

public class Rooms {
    private static final Random random = new Random();


    static String generateRandomRoomDescription() {
        String[] Description = {" into a dark and damp room. What do you want to do?",
                "A simple, stone-walled room with a dirt floor. The only light comes from a flickering torch mounted on the wall." +
                        " It's barren, save for a few scattered bones and cobwebs. The air is damp, and a faint scent of moss lingers.",
                "A low-ceilinged cavern covered in damp moss and lichen. Water drips from the ceiling, creating small puddles on the uneven\n" +
                        " ground. The room is dimly lit by the glow of bioluminescent fungi growing on the walls. The atmosphere is cool and slightly musty.",
                "A room encased in sticky webs, with large, skittering spiders crawling around. The air feels thick with silk, and the room is eerily silent\n" +
                        " except for the occasional sound of a spider moving. The walls are obscured by webs, and the floor crunches underfoot from the remnants of past meals.",
                "A room filled with strange, glowing mushrooms of various shapes and sizes. Their soft light illuminates the space in an eerie, multicolored glow.\n" +
                        " The air is heavy with the scent of earth and mushrooms. The ground is uneven due to the fungal growth, and occasional spores float through the air.",
                "A chamber with stone sarcophagi lining the walls. Dust covers the ornate carvings on the ancient tombs. The air is still, and a faint, lingering scent of\n" +
                        " incense hangs in the air. The room feels solemn and carries an air of reverence."};
        Random random = new Random();
        int index = random.nextInt(Description.length);
        return Description[index];
    }
}
