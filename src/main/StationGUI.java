/**
 * StationGUI class represents a GUI made with Java Swing for displaying train station information.
 * It includes a table showing station details such as the station name, departure, and calculated arrival time,
 * along with a label displaying the route for the selected station.
 * The station data is initialized within the constructor, and the arrival time is calculated based
 * on the travel times retrieved from the TrainStationManager class.
 */
package main;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class StationGUI extends JFrame {
    private static final long serialVersionUID = -4578242566311054557L;
    private JTable table;
    private JLabel routeLabel;
    private Map<String, String> routeMap;
    TrainStationManager tsm = new TrainStationManager("stations.csv");

    /**
     * Constructs a StationGUI object.
     * Initializes the GUI components including the table displaying the station information and
     * the label for showing the routes. It also initializes the routeMap for storing
     * route information for each station.
     */
    public StationGUI() {
        setTitle("Welcome to Westside Station!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 270);

        // Station data initialization
        String[][] data = {
                {"Bugapest", "9:35pm" , calculateArrivalTime("Bugapest", 9, ":", 35,"am")},
                {"Dubay", "10:30am" , calculateArrivalTime("Dubay", 10, ":", 30, "am")},
                {"Berlint", "8:25pm", calculateArrivalTime("Berlint", 8, ":", 25, "pm")},
                {"Mosbull", "6:00pm", calculateArrivalTime("Mosbull", 6, ":", 0, "pm")},
                {"Cayro", "6:40am", calculateArrivalTime("Cayro", 6, ":", 40, "am")},
                {"Bostin", "10:25am", calculateArrivalTime("Bostin", 10, ":", 25, "am")},
                {"Los Angelos", "12:30pm", calculateArrivalTime("Los Angelos", 12, ":", 30, "pm")},
                {"Dome", "1:30pm", calculateArrivalTime("Dome", 1, ":", 30, "pm")},
                {"Takyo", "3:35pm", calculateArrivalTime("Takyo", 3, ":", 35, "pm")},
                {"Unstabul", "4:45pm", calculateArrivalTime("Unstabul", 4, ":", 45, "pm")},
                {"Chicargo", "7:25am", calculateArrivalTime("Chicargo", 7, ":", 25, "am")},
                {"Loondun", "2:00pm", calculateArrivalTime("Loondun", 2, ":", 0, "pm")}
        };

        // Route information initialization
        routeMap = new HashMap<>();
        routeMap.put("Bugapest", "Route for Bugapest: " + tsm.traceRoute("Bugapest"));
        routeMap.put("Dubay", "Route for Dubay: " + tsm.traceRoute("Dubay"));
        routeMap.put("Berlint", "Route for Berlint: " + tsm.traceRoute("Berlint"));
        routeMap.put("Mosbull", "Route for Mosbull: " + tsm.traceRoute("Mosbull"));
        routeMap.put("Cayro", "Route for Cayro: " + tsm.traceRoute("Cayro"));
        routeMap.put("Bostin", "Route for Bostin: " + tsm.traceRoute("Bostin"));
        routeMap.put("Los Angelos", "Route for Los Angelos: " + tsm.traceRoute("Los Angelos"));
        routeMap.put("Dome", "Route for Dome: " + tsm.traceRoute("Dome"));
        routeMap.put("Takyo", "Route for Takyo: " + tsm.traceRoute("Takyo"));
        routeMap.put("Unstabul", "Route for Unstabul: " + tsm.traceRoute("Unstabul"));
        routeMap.put("Chicargo", "Route for Chicargo: " + tsm.traceRoute("Chicargo"));
        routeMap.put("Loondun", "Route for Loondun: " + tsm.traceRoute("Loondun"));

        String[] columnNames = {"Station", "Departure", "Arrival"};

        table = new JTable(data, columnNames) {
            private static final long serialVersionUID = -6151100191811511840L; //i dont know what this is for, but eclipse said to put it.

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Sets the data inside the table to the center of the cells
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Every time you click on a station it displays the route information in the bottom of the window.
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    if (table.getSelectedRow() != -1) {
                        String station = (String) table.getValueAt(table.getSelectedRow(), 0);
                        routeLabel.setText(routeMap.get(station));
                    }
                }
            }
        });

        routeLabel = new JLabel("Route: ");

        JScrollPane scrollPane = new JScrollPane(table);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(routeLabel, BorderLayout.SOUTH);
    }

    /**
     * Main method to launch the application.
     * Creates and displays the StationGUI.
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StationGUI().setVisible(true);
            }
        });
    }

    /**
     * Calculates the arrival time for a given station based on its departure time and travel time from the TrainStationManager method getTravelTime.
     * @param station The name of the station
     * @param hour The hour of departure
     * @param colon The separator between hour and minute (":")
     * @param minute The minutes of departure
     * @param AMPM The period of the day (AM/PM)
     * @return The calculated arrival time formatted as "hh:mmAM/PM"
     */
    public String calculateArrivalTime(String station, int hour, String colon, int minute, String AMPM) {
    	//adds the travel time as well as the minutes of departure
        double travelTime = tsm.getTravelTimes().get(station) + minute;
        
        //the hours in travel time and the hour of departure
        int hours = (int) (travelTime / 60 ) + hour;
       
        //calculates the minutes of travel time
        int minutes = (int) travelTime % 60;
        
        //"AM/PM"
        String meridiem = AMPM;
        
        if(hours > 12 && meridiem.equals("am")) {
            hours -= 12;
            meridiem = "pm";
        }
        else if(hours > 12 && meridiem.equals("pm")) {
            hours -= 12;
            meridiem = "am";
        }

        return hours + colon + minutes + meridiem;
    }
}
