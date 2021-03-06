package thermal_analyser_tests

import thermal_analyser._
import org.junit._
import junit.framework.Assert._

class Score_calculator_Test {
	
	@Test
	def calculates_top_1_score_from_1x1_grid {

		val grid = new Grid(List(List(5)))
		val scores = new SimpleScoreCalculator().calculate(1, grid)

		assertEquals(List((0, 0, 5)), scores)
	}

	@Test
	def calculates_top_1_score_from_3x3_grid {
		
		val grid = new Grid(List( List(1, 2, 1), List(2, 1, 5), List(2, 1, 2) ))
		val scores = new SimpleScoreCalculator().calculate(1, grid)

		assertEquals(List((1, 1, 17)), scores)
	}

	@Test
	def calculates_top_3_scores_from_a_4x4_grid {

		val grid = new Grid( List( List(2, 3, 2, 1), List(4, 4, 2, 0), List(3, 4, 1, 1), List(2, 3, 4, 4) ))
		val scores = new SimpleScoreCalculator().calculate(3, grid)

		val resultsForQuery = List( (1, 2, 27), (1, 1, 25), (2, 2, 23) )

		assertEquals(resultsForQuery, scores)
	}
}