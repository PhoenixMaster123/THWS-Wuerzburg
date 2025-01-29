package ChatGPT.BuilderPattern;

public class Main {
    public static void main(String[] args) {
        ReisePlan reise = new ReisePlan.ReisePlanBuilder()
                .startort("Berlin")
                .zielort("Paris")
                .reisedauer(5)
                .transportmittel("Zug")
                .addSehenswuerdigkeit("Eiffelturm")
                .addSehenswuerdigkeit("Louvre")
                .printPlan()
                .build();

        System.out.println("\nReiseplan erstellt:");
        System.out.println(reise);

        // Test der Unveränderbarkeit der Liste
        try {
            reise.getSehenswuerdigkeiten().add("Notre-Dame");
        } catch (UnsupportedOperationException e) {
            System.out.println("\nFehler: Die Liste der Sehenswürdigkeiten kann nicht verändert werden!");
        }
    }
}
