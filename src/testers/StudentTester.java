package testers;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import data_structures.ArrayListStack;
import data_structures.HashTableSC;
import data_structures.SimpleHashFunction;
import interfaces.List;
import interfaces.Map;
import interfaces.Stack;
import main.Station;
import main.TrainStationManager;


/*
 * ***************************DO NOT MODIFY!!!!!!!*****************************************
 * That is all.
 */
public class StudentTester {
	@DisplayName("Testing the Creation of the Station Map")
	@Nested
	public class TestingStationMap{
		TrainStationManager tsm = new TrainStationManager("stations.csv");
		Map<String, List<Station>> stations = tsm.getStations();
		@Test
		@DisplayName("Testing if Westside was correctly added")
		public void cityMapTester1() throws IOException {
			assertAll(
					() -> assertTrue(stations.get("Westside").size() == 3, "Failed to correct amount of destinations to Westside."),
					() -> assertTrue(stations.get("Westside").contains(new Station("Dubay", 100)), "Failed to add Dubay to Westside."),
					() -> assertTrue(stations.get("Westside").contains(new Station("Mosbull", 92)), "Failed to add Mosbull to Westside."),
					() -> assertTrue(stations.get("Westside").contains(new Station("Bugapest", 55)), "Failed to add Bugapest to Westside.")
					);

		}
		@Test
		@DisplayName("Testing if Dubay was correctly added")
		public void cityMapTester2() throws IOException {
			assertAll(
					() -> assertTrue(stations.get("Dubay").size() == 4, "Failed to correct amount of destinations to Dubay."),
					() -> assertTrue(stations.get("Dubay").contains(new Station("Berlint", 44)), "Failed to add Berlint to Dubay."),
					() -> assertTrue(stations.get("Dubay").contains(new Station("Westside", 100)), "Failed to add Westside to Dubay."),
					() -> assertTrue(stations.get("Dubay").contains(new Station("Los Angelos", 57)), "Failed to add Los Angelos to Dubay."),
					() -> assertTrue(stations.get("Dubay").contains(new Station("Cayro", 25)), "Failed to add Cayro to Dubay.")
					);

		}
		@Test
		@DisplayName("Testing if Berlint was correctly added")
		public void cityMapTester3() throws IOException {
			assertAll(
					() -> assertTrue(stations.get("Berlint").size() == 2, "Failed to correct amount of destinations to Berlint."),
					() -> assertTrue(stations.get("Berlint").contains(new Station("Dubay", 44)), "Failed to add Dubay to Berlint."),
					() -> assertTrue(stations.get("Berlint").contains(new Station("Mosbull", 64)), "Failed to add Mosbull to Berlint.")
					);
		}

		@Test
		@DisplayName("Testing if Mosbull was correctly added")
		public void cityMapTester4() throws IOException {
			assertAll(
					() -> assertTrue(stations.get("Mosbull").size() == 4, "Failed to correct amount of destinations to Mosbull."),
					() -> assertTrue(stations.get("Mosbull").contains(new Station("Berlint", 64)), "Failed to add Berlint to Mosbull."),
					() -> assertTrue(stations.get("Mosbull").contains(new Station("Westside", 92)), "Failed to add Westside to Mosbull."),
					() -> assertTrue(stations.get("Mosbull").contains(new Station("Loondun", 87)), "Failed to add Loondun to Mosbull."),
					() -> assertTrue(stations.get("Mosbull").contains(new Station("Bostin", 63)), "Failed to add Bostin to Mosbull.")
					);
		}

		@Test
		@DisplayName("Testing if Loondun was correctly added")
		public void cityMapTester5() throws IOException {
			assertAll(
					() -> assertTrue(stations.get("Loondun").size() == 4, "Failed to correct amount of destinations to Loondun."),
					() -> assertTrue(stations.get("Loondun").contains(new Station("Bostin", 43)), "Failed to add Bostin to Loondun."),
					() -> assertTrue(stations.get("Loondun").contains(new Station("Unstabul", 120)), "Failed to add Unstabul to Loondun."),
					() -> assertTrue(stations.get("Loondun").contains(new Station("Mosbull", 87)), "Failed to add Unstabul to Loondun."),
					() -> assertTrue(stations.get("Loondun").contains(new Station("Chicargo", 23)), "Failed to add Chicargo to Loondun.")
					);
		}

		@Test
		@DisplayName("Testing if Chicargo was correctly added")
		public void cityMapTester6() throws IOException {
			assertAll(
					() -> assertTrue(stations.get("Chicargo").size() == 2, "Failed to correct amount of destinations to Chicargo."),
					() -> assertTrue(stations.get("Chicargo").contains(new Station("Unstabul", 70)), "Failed to add Unstabul to Chicargo."),
					() -> assertTrue(stations.get("Chicargo").contains(new Station("Loondun", 23)), "Failed to add Loondun to Chicargo.")
					);
		}

		@Test
		@DisplayName("Testing if Unstabul was correctly added")
		public void cityMapTester7() throws IOException {
			assertAll(
					() -> assertTrue(stations.get("Unstabul").size() == 4, "Failed to correct amount of destinations to Unstabul."),
					() -> assertTrue(stations.get("Unstabul").contains(new Station("Bugapest", 61)), "Failed to add Bugapest to Unstabul."),
					() -> assertTrue(stations.get("Unstabul").contains(new Station("Chicargo", 70)), "Failed to add Chicargo to Unstabul."),
					() -> assertTrue(stations.get("Unstabul").contains(new Station("Takyo", 42)), "Failed to add Takyo to Unstabul."),
					() -> assertTrue(stations.get("Unstabul").contains(new Station("Loondun", 120)), "Failed to add Loondun to Unstabul.")
					);
		}

		@Test
		@DisplayName("Testing if Cayro was correctly added")
		public void cityMapTester8() throws IOException {
			assertAll(
					() -> assertTrue(stations.get("Cayro").size() == 5, "Failed to correct amount of destinations to Cayro."),
					() -> assertTrue(stations.get("Cayro").contains(new Station("Takyo", 27)), "Failed to add Takyo to Cayro."),
					() -> assertTrue(stations.get("Cayro").contains(new Station("Los Angelos", 33)), "Failed to add Los Angelos to Cayro."),
					() -> assertTrue(stations.get("Cayro").contains(new Station("Dubay", 25)), "Failed to add Dubay to Cayro."),
					() -> assertTrue(stations.get("Cayro").contains(new Station("Dome", 45)), "Failed to add Dome to Cayro."),
					() -> assertTrue(stations.get("Cayro").contains(new Station("Bugapest", 30)), "Failed to add Bugapest to Cayro.")
					);
		}

		@Test
		@DisplayName("Testing if Takyo was correctly added")
		public void cityMapTester9() throws IOException {
			assertAll(
					() -> assertTrue(stations.get("Takyo").size() == 3, "Failed to correct amount of destinations to Takyo."),
					() -> assertTrue(stations.get("Takyo").contains(new Station("Dome", 57)), "Failed to add Dome to Takyo."),
					() -> assertTrue(stations.get("Takyo").contains(new Station("Unstabul", 42)), "Failed to add Unstabul to Takyo."),
					() -> assertTrue(stations.get("Takyo").contains(new Station("Cayro", 27)), "Failed to add Cayro to Takyo.")
					);
		}

		@Test
		@DisplayName("Testing if Dome was correctly added")
		public void cityMapTester10() throws IOException {
			assertAll(
					() -> assertTrue(stations.get("Dome").size() == 3, "Failed to correct amount of destinations to Dome."),
					() -> assertTrue(stations.get("Dome").contains(new Station("Los Angelos", 88)), "Failed to add Los Angelos to Dome."),
					() -> assertTrue(stations.get("Dome").contains(new Station("Cayro", 45)), "Failed to add Cayro to Dome."),
					() -> assertTrue(stations.get("Dome").contains(new Station("Takyo", 57)), "Failed to add Takyo to Dome.")
					);
		}
		@Test
		@DisplayName("Testing if Bostin was correctly added")
		public void cityMapTester11() throws IOException {
			assertAll(
					() -> assertTrue(stations.get("Bostin").size() == 3, "Failed to correct amount of destinations to Bonstin."),
					() -> assertTrue(stations.get("Bostin").contains(new Station("Mosbull", 63)), "Failed to add Mosbull to Bostin."),
					() -> assertTrue(stations.get("Bostin").contains(new Station("Loondun", 43)), "Failed to add Loondun to Bostin."),
					() -> assertTrue(stations.get("Bostin").contains(new Station("Bugapest", 16)), "Failed to add Bugapest to Bostin.")
					);
		}
		@Test
		@DisplayName("Testing if Bugapest was correctly added")
		public void cityMapTester12() throws IOException {
			assertAll(
					() -> assertTrue(stations.get("Bugapest").size() == 4, "Failed to correct amount of destinations to Bugapest."),
					() -> assertTrue(stations.get("Bugapest").contains(new Station("Westside", 55)), "Failed to add Westside to Bugapest."),
					() -> assertTrue(stations.get("Bugapest").contains(new Station("Unstabul", 61)), "Failed to add Unstabul to Bugapest."),
					() -> assertTrue(stations.get("Bugapest").contains(new Station("Bostin", 16)), "Failed to add Bostin to Bugapest."),
					() -> assertTrue(stations.get("Bugapest").contains(new Station("Cayro", 30)), "Failed to add Cayro to Bugapest.")
					);
		}
		@Test
		@DisplayName("Testing if Los Angelos was correctly added")
		public void cityMapTester13() throws IOException {
		    assertAll(
		    		() -> assertTrue(stations.get("Los Angelos").size() == 3, "Failed to correct amount of destinations to Los Angelos."),
		            () -> assertTrue(stations.get("Los Angelos").contains(new Station("Dubay", 57)), "Failed to add Dubay to Los Angelos."),
		            () -> assertTrue(stations.get("Los Angelos").contains(new Station("Dome", 88)), "Failed to add Dome to Los Angelos."),
		            () -> assertTrue(stations.get("Los Angelos").contains(new Station("Cayro", 33)), "Failed to add Cayro to Los Angelos.")
		            );
		}

	}
	@DisplayName("Testing the Stack Sorter")
	@Nested
	public class TestingStackSort {
		TrainStationManager tsm = new TrainStationManager("stations.csv");
		
		private boolean compareStack(String[] items, Stack<Station> stack) {
			if(items.length != stack.size())
				return false;
			for(int i = 0; i < items.length; i++) {
				if(!items[i].equals(stack.pop().getCityName()))
					return false;
			}
			return true;
		}
		@Test
		@DisplayName("Testing stack sorting")
		public void stackSortTest() {
			String[] items = {"Apu", "Ned", "Jil", "Mel", "Joe", "Kim"};
			Stack<Station> stack = new ArrayListStack<>(6);
			Map<String, Station> distances = new HashTableSC<>(6, new SimpleHashFunction<>());
			distances.put("Apu", new Station("Apu", 40));
			distances.put("Joe", new Station("Joe", 2));
			distances.put("Mel", new Station("Mel", 30));
			distances.put("Jil", new Station("Jil", 70));
			distances.put("Ned", new Station("Ned", 20));
			distances.put("Kim", new Station("Kim", 50));
			for(String str: items) {
				tsm.sortStack(distances.get(str), stack);
			}
			String[] items2 = {"Joe", "Ned", "Mel", "Apu", "Kim", "Jil"};
			assertTrue(compareStack(items2, stack), "Stack wasn't sorted correctly.");
			
		}
	}
	@DisplayName("Testing the Shortest Paths")
	@Nested
	public class TestingShortestRoutes {
		TrainStationManager tsm = new TrainStationManager("stations.csv");
		
		@Test
		@DisplayName("Testing shortest route to Westside")
		public void shortestRouteTestWestside() {
			assertEquals(0, tsm.getShortestRoutes().get("Westside").getDistance(), "Failed to assign correct distance to Westside.");
		}
		@Test
	    @DisplayName("Testing shortest route to Loondun")
	    public void shortestRouteTestLoondun() {
	        assertEquals(114, tsm.getShortestRoutes().get("Loondun").getDistance(), "Failed to assign correct distance to Loondun.");
	    }

	    @Test
	    @DisplayName("Testing shortest route to Mosbull")
	    public void shortestRouteTestMosbull() {
	        assertEquals(92, tsm.getShortestRoutes().get("Mosbull").getDistance(), "Failed to assign correct distance to Mosbull.");
	    }

	    @Test
	    @DisplayName("Testing shortest route to Cayro")
	    public void shortestRouteTestCayro() {
	        assertEquals(85, tsm.getShortestRoutes().get("Cayro").getDistance(), "Failed to assign correct distance to Cayro.");
	    }

	    @Test
	    @DisplayName("Testing shortest route to Dome")
	    public void shortestRouteTestDome() {
	        assertEquals(130, tsm.getShortestRoutes().get("Dome").getDistance(), "Failed to assign correct distance to Dome.");
	    }

	    @Test
	    @DisplayName("Testing shortest route to Bugapest")
	    public void shortestRouteTestBugapest() {
	        assertEquals(55, tsm.getShortestRoutes().get("Bugapest").getDistance(), "Failed to assign correct distance to Bugapest.");
	    }

	    @Test
	    @DisplayName("Testing shortest route to Los Angelos")
	    public void shortestRouteTestLosAngelos() {
	        assertEquals(118, tsm.getShortestRoutes().get("Los Angelos").getDistance(), "Failed to assign correct distance to Los Angelos.");
	    }

	    @Test
	    @DisplayName("Testing shortest route to Unstabul")
	    public void shortestRouteTestUnstabul() {
	        assertEquals(116, tsm.getShortestRoutes().get("Unstabul").getDistance(), "Failed to assign correct distance to Unstabul.");
	    }

	    @Test
	    @DisplayName("Testing shortest route to Bostin")
	    public void shortestRouteTestBostin() {
	        assertEquals(71, tsm.getShortestRoutes().get("Bostin").getDistance(), "Failed to assign correct distance to Bostin.");
	    }

	    @Test
	    @DisplayName("Testing shortest route to Dubay")
	    public void shortestRouteTestDubay() {
	        assertEquals(100, tsm.getShortestRoutes().get("Dubay").getDistance(), "Failed to assign correct distance to Dubay.");
	    }

	    @Test
	    @DisplayName("Testing shortest route to Takyo")
	    public void shortestRouteTestTakyo() {
	        assertEquals(112, tsm.getShortestRoutes().get("Takyo").getDistance(), "Failed to assign correct distance to Takyo.");
	    }

	    @Test
	    @DisplayName("Testing shortest route to Berlint")
	    public void shortestRouteTestBerlint() {
	        assertEquals(144, tsm.getShortestRoutes().get("Berlint").getDistance(), "Failed to assign correct distance to Berlint.");
	    }

	    @Test
	    @DisplayName("Testing shortest route to Chicargo")
	    public void shortestRouteTestChicargo() {
	        assertEquals(137, tsm.getShortestRoutes().get("Chicargo").getDistance(), "Failed to assign correct distance to Chicargo.");
	    }
	}
	@DisplayName("Testing the Travel Time")
	@Nested
	public class TestingTravelTime {
		TrainStationManager tsm = new TrainStationManager("stations.csv");
		

		@Test
		@DisplayName("Testing Travel Time for Westside")
		public void travelTimeWestside() {
			Map<String, Double> times = tsm.getTravelTimes();
			assertEquals(0, times.get("Westside"), "Failed to give corrrect travel tome for Westside.");			
		}
		@Test
	    @DisplayName("Testing Travel Time for Dome")
	    public void travelTimeTestDome() {
	        Map<String, Double> times = tsm.getTravelTimes();
	        assertEquals(355.0, times.get("Dome"), "Failed to give correct travel time for Dome.");
	    }

	    @Test
	    @DisplayName("Testing Travel Time for Bostin")
	    public void travelTimeTestBostin() {
	        Map<String, Double> times = tsm.getTravelTimes();
	        assertEquals(192.5, times.get("Bostin"), "Failed to give correct travel time for Bostin.");
	    }

	    @Test
	    @DisplayName("Testing Travel Time for Bugapest")
	    public void travelTimeTestBugapest() {
	        Map<String, Double> times = tsm.getTravelTimes();
	        assertEquals(137.5, times.get("Bugapest"), "Failed to give correct travel time for Bugapest.");
	    }
	    @Test
	    @DisplayName("Testing Travel Time for Loondun")
	    public void travelTimeTestLoondun() {
	        Map<String, Double> times = tsm.getTravelTimes();
	        assertEquals(315.0, times.get("Loondun"), "Failed to give correct travel time for Loondun.");
	    }

	    @Test
	    @DisplayName("Testing Travel Time for Los Angelos")
	    public void travelTimeTestLosAngelos() {
	        Map<String, Double> times = tsm.getTravelTimes();
	        assertEquals(325.0, times.get("Los Angelos"), "Failed to give correct travel time for Los Angelos.");
	    }

	    @Test
	    @DisplayName("Testing Travel Time for Dubay")
	    public void travelTimeTestDubay() {
	        Map<String, Double> times = tsm.getTravelTimes();
	        assertEquals(250.0, times.get("Dubay"), "Failed to give correct travel time for Dubay.");
	    }

	    @Test
	    @DisplayName("Testing Travel Time for Chicargo")
	    public void travelTimeTestChicargo() {
	        Map<String, Double> times = tsm.getTravelTimes();
	        assertEquals(387.5, times.get("Chicargo"), "Failed to give correct travel time for Chicargo.");
	    }

	    @Test
	    @DisplayName("Testing Travel Time for Mosbull")
	    public void travelTimeTestMosbull() {
	        Map<String, Double> times = tsm.getTravelTimes();
	        assertEquals(230.0, times.get("Mosbull"), "Failed to give correct travel time for Mosbull.");
	    }

	    @Test
	    @DisplayName("Testing Travel Time for Berlint")
	    public void travelTimeTestBerlint() {
	        Map<String, Double> times = tsm.getTravelTimes();
	        assertEquals(375.0, times.get("Berlint"), "Failed to give correct travel time for Berlint.");
	    }

	    @Test
	    @DisplayName("Testing Travel Time for Cayro")
	    public void travelTimeTestCayro() {
	        Map<String, Double> times = tsm.getTravelTimes();
	        assertEquals(227.5, times.get("Cayro"), "Failed to give correct travel time for Cayro.");
	    }

	    @Test
	    @DisplayName("Testing Travel Time for Unstabul")
	    public void travelTimeTestUnstabul() {
	        Map<String, Double> times = tsm.getTravelTimes();
	        assertEquals(305.0, times.get("Unstabul"), "Failed to give correct travel time for Unstabul.");
	    }

	    @Test
	    @DisplayName("Testing Travel Time for Takyo")
	    public void travelTimeTestTakyo() {
	        Map<String, Double> times = tsm.getTravelTimes();
	        assertEquals(310.0, times.get("Takyo"), "Failed to give correct travel time for Takyo.");
	    }
	}
	/*
	 * For the BONUS
	 */
	@DisplayName("Testing the Trace Route")
	@Nested
	public class TestingTrace {
		TrainStationManager tsm = new TrainStationManager("stations.csv");
		

		@Test
		@DisplayName("Testing Trace Route for Westside")
		public void traceWestside() {
			try {
			assertEquals("Westside", tsm.traceRoute("Westside"), "Failed to give corrrect travel tome for Westside.");
			} catch (UnsupportedOperationException e) {
				System.out.println("Bonus not implemented");
			}
		}
		@Test
	    @DisplayName("Testing Trace Route for Bostin")
	    public void traceBostin() {
	        try {
	            assertEquals("Westside->Bugapest->Bostin", tsm.traceRoute("Bostin"), "Failed to give correct travel route for Bostin.");
	        } catch (UnsupportedOperationException e) {
	            System.out.println("Bonus not implemented");
	        }
	    }

	    @Test
	    @DisplayName("Testing Trace Route for Bugapest")
	    public void traceBugapest() {
	        try {
	            assertEquals("Westside->Bugapest", tsm.traceRoute("Bugapest"), "Failed to give correct travel route for Bugapest.");
	        } catch (UnsupportedOperationException e) {
	            System.out.println("Bonus not implemented");
	        }
	    }

	    @Test
	    @DisplayName("Testing Trace Route for Dubay")
	    public void traceDubay() {
	        try {
	            assertEquals("Westside->Dubay", tsm.traceRoute("Dubay"), "Failed to give correct travel route for Dubay.");
	        } catch (UnsupportedOperationException e) {
	            System.out.println("Bonus not implemented");
	        }
	    }

	    @Test
	    @DisplayName("Testing Trace Route for Chicargo")
	    public void traceChicargo() {
	        try {
	            assertEquals("Westside->Bugapest->Bostin->Loondun->Chicargo", tsm.traceRoute("Chicargo"), "Failed to give correct travel route for Chicargo.");
	        } catch (UnsupportedOperationException e) {
	            System.out.println("Bonus not implemented");
	        }
	    }

	    @Test
	    @DisplayName("Testing Trace Route for Cayro")
	    public void traceCayro() {
	        try {
	            assertEquals("Westside->Bugapest->Cayro", tsm.traceRoute("Cayro"), "Failed to give correct travel route for Cayro.");
	        } catch (UnsupportedOperationException e) {
	            System.out.println("Bonus not implemented");
	        }
	    }

	    @Test
	    @DisplayName("Testing Trace Route for Unstabul")
	    public void traceUnstabul() {
	        try {
	            assertEquals("Westside->Bugapest->Unstabul", tsm.traceRoute("Unstabul"), "Failed to give correct travel route for Unstabul.");
	        } catch (UnsupportedOperationException e) {
	            System.out.println("Bonus not implemented");
	        }
	    }

	    @Test
	    @DisplayName("Testing Trace Route for Dome")
	    public void traceDome() {
	        try {
	            assertEquals("Westside->Bugapest->Cayro->Dome", tsm.traceRoute("Dome"), "Failed to give correct travel route for Dome.");
	        } catch (UnsupportedOperationException e) {
	            System.out.println("Bonus not implemented");
	        }
	    }

	    @Test
	    @DisplayName("Testing Trace Route for Takyo")
	    public void traceTakyo() {
	        try {
	            assertEquals("Westside->Bugapest->Cayro->Takyo", tsm.traceRoute("Takyo"), "Failed to give correct travel route for Takyo.");
	        } catch (UnsupportedOperationException e) {
	            System.out.println("Bonus not implemented");
	        }
	    }

	    @Test
	    @DisplayName("Testing Trace Route for Loondun")
	    public void traceLoondun() {
	        try {
	            assertEquals("Westside->Bugapest->Bostin->Loondun", tsm.traceRoute("Loondun"), "Failed to give correct travel route for Loondun.");
	        } catch (UnsupportedOperationException e) {
	            System.out.println("Bonus not implemented");
	        }
	    }

	    @Test
	    @DisplayName("Testing Trace Route for Los Angelos")
	    public void traceLosAngelos() {
	        try {
	            assertEquals("Westside->Bugapest->Cayro->Los Angelos", tsm.traceRoute("Los Angelos"), "Failed to give correct travel route for Los Angelos.");
	        } catch (UnsupportedOperationException e) {
	            System.out.println("Bonus not implemented");
	        }
	    }

	    @Test
	    @DisplayName("Testing Trace Route for Mosbull")
	    public void traceMosbull() {
	        try {
	            assertEquals("Westside->Mosbull", tsm.traceRoute("Mosbull"), "Failed to give correct travel route for Mosbull.");
	        } catch (UnsupportedOperationException e) {
	            System.out.println("Bonus not implemented");
	        }
	    }

	    @Test
	    @DisplayName("Testing Trace Route for Berlint")
	    public void traceBerlint() {
	        try {
	            assertEquals("Westside->Dubay->Berlint", tsm.traceRoute("Berlint"), "Failed to give correct travel route for Berlint");
	        } catch (UnsupportedOperationException e) {
	            System.out.println("Bonus not implemented");
	        }
	    }
	}

}
