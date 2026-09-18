package com.campuspulse.assistant;

public class CampusAssistant {

    private final String assistantName = "Pulse";

    public String getAssistantName() {
        return assistantName;
    }


    public String getResponse(String question) {

        if (question == null || question.trim().isEmpty()) {
            return "Please ask me something. I'm listening!";
        }

        String input = question.toLowerCase().trim();


        // Greetings
        if (input.equals("hi") ||
                input.equals("hello") ||
                input.equals("hey") ||
                input.contains("good morning") ||
                input.contains("good afternoon") ||
                input.contains("good evening")) {

            return "Hey! I'm Pulse, your CampusPulse assistant. "
                    + "How can I help you today?";
        }


        // Identity
        if (input.contains("who are you") ||
                input.contains("your name") ||
                input.contains("what are you")) {

            return "I'm Pulse, the virtual assistant for CampusPulse. "
                    + "I help students navigate campus services and information.";
        }


        // Capabilities
        if (input.contains("what can you do") ||
                input.contains("how can you help") ||
                input.equals("help") ||
                input.contains("what do you help")) {

            return "I can help with campus issues, mess information, "
                    + "library records, facilities, and analytics. "
                    + "Just ask me about one of them";
        }


        // Issue Management
        if (input.contains("issue") ||
                input.contains("complaint") ||
                input.contains("repair") ||
                input.contains("broken") ||
                input.contains("maintenance problem")) {

            return "Sounds like a campus issue. You can report it "
                    + "through the Issue Management module, where it "
                    + "can be tracked by status and priority.";
        }


        // Mess Management
        if (input.contains("mess") ||
                input.contains("food") ||
                input.contains("meal") ||
                input.contains("menu") ||
                input.contains("rating")) {

            return "For food and mess-related information, you can use "
                    + "the Mess Management module to view meals, submit "
                    + "ratings, and provide feedback.";
        }


        // Library Management
        if (input.contains("library") ||
                input.contains("book") ||
                input.contains("borrow") ||
                input.contains("return book")) {

            return "The Library Management module lets you issue books, "
                    + "view library records, and return books.";
        }


        // Facilities Management
        if (input.contains("facility") ||
                input.contains("facilities") ||
                input.contains("lab") ||
                input.contains("classroom") ||
                input.contains("equipment")) {

            return "You can check and manage campus facilities through "
                    + "the Facilities Management module, including their "
                    + "location, status, and maintenance information.";
        }


        // Analytics
        if (input.contains("analytics") ||
                input.contains("statistics") ||
                input.contains("report") ||
                input.contains("data") ||
                input.contains("summary")) {

            return "CampusPulse provides analytics for issues, mess, "
                    + "library, and facilities. You can view individual "
                    + "summaries or the complete analytics report.";
        }


        // Thanks
        if (input.contains("thank") ||
                input.contains("thanks")) {

            return "You're welcome! That's what I'm here for. ";
        }


        // Goodbye
        if (input.equals("bye") ||
                input.equals("goodbye") ||
                input.contains("see you")) {

            return "See you later! Keep the campus running smoothly. ";
        }


        // Default response
        return "I'm not quite sure about that yet. Try asking me about "
                + "issues, mess, library, facilities, or analytics.";
    }
}