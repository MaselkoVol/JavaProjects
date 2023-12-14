package tourTicket.util;

import tourTicket.Ingestion;

import java.sql.Time;

class IngestionExemplars {
    public static Ingestion BREAKFAST_1 = new Ingestion("Main course: scrambled eggs with sausages. Dessert: pancakes with jam", new Time(9, 0, 0));
    public static Ingestion BREAKFAST_2 = new Ingestion("Main: Broth with bread. Dessert: croissant", new Time(10, 0, 0));
    public static Ingestion BREAKFAST_3 = new Ingestion("Main: porridge. Dessert: cake", new Time(9, 30, 0));
    public static Ingestion DINNER_1 = new Ingestion("Main: potatoes with chicken wings in sauce. Dessert: cake", new Time(14, 0, 0));
    public static Ingestion DINNER_2 = new Ingestion("Main: pasta with beef. Dessert: cruissant", new Time(15, 0, 0));
    public static Ingestion DINNER_3 = new Ingestion("Main: pork steak. Dessert: cake", new Time(14, 30, 0));
    public static Ingestion SUPPER_1 = new Ingestion("Main: beans.", new Time(18, 0, 0));
    public static Ingestion SUPPER_2 = new Ingestion("Main: mushroom salad. Dessert: cake", new Time(19, 0, 0));
    public static Ingestion SUPPER_3 = new Ingestion("Main: fruit with a croissant.", new Time(18, 30, 0));




}
