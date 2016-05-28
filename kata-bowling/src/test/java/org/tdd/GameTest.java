package org.tdd;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GameTest {

	//Extra rolls calculation
	@Test
	public void EndingWithSpareGivesOneExtra() {
		Game game = new Game("XXXXXXXXX-/1");
		int scoringLength = game.getScoring().length();
		int extraRollscount = game.getScoringWithoutExtraRolls().length();

		assertThat(scoringLength-extraRollscount,is(1));
	}

	@Test
	public void EndingWithStrikeGivesTwoExtra() {
		Game game = new Game("XXXXXXXXXX12");
		int scoringLength = game.getScoring().length();
		int extraRollscount = game.getScoringWithoutExtraRolls().length();

		assertThat(scoringLength-extraRollscount,is(2));
	}

	//parsing
	@Test
	public void TestGame1Has10Frames() {
		Game game = new Game("XXXXXXXXXXXX");
		assertThat(game.parseFrames().size(),is(10));
	}

	@Test
	public void TestGame2Has10Frames() {
		Game game = new Game("9-9-9-9-9-9-9-9-9-9-");
		assertThat(game.parseFrames().size(),is(10));
	}

	@Test
	public void TestGame3Has10Frames() {
		Game game = new Game("5/5/5/5/5/5/5/5/5/5/5");
		assertThat(game.parseFrames().size(),is(10));
	}

	//points calculation;

	@Test
	public void NullGame2Scores0() {
		Game game = new Game("--------------------");
		assertThat(game.getPoints(),is(0));
	}

	@Test
	public void TestGame2Scores90() {
		Game game = new Game("9-9-9-9-9-9-9-9-9-9-");
		assertThat(game.getPoints(),is(90));
	}

	@Test
	public void TestGame3Scores150() {
		Game game = new Game("5/5/5/5/5/5/5/5/5/5/5");
		assertThat(game.getPoints(),is(150));
	}

	@Test
	public void TestGame1Scores300() {
		Game game = new Game("XXXXXXXXXXXX");
		assertThat(game.getPoints(),is(300));
	}

}
