package org.tdd;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FrameTest {

	//Base points calculation
	@Test
	public void MissMissReturns0() {
		Frame frame = new Frame("--");
		assertThat(frame.getBasePoints(),is(0));
	}

	@Test
	public void MissThreeReturns3() {
		Frame frame = new Frame("-3");
		assertThat(frame.getBasePoints(),is(3));
	}

	@Test
	public void ThreeMissReturns3() {
		Frame frame = new Frame("3-");
		assertThat(frame.getBasePoints(),is(3));
	}

	@Test
	public void ThreeFourReturns7() {
		Frame frame = new Frame("34");
		assertThat(frame.getBasePoints(),is(7));
	}

	@Test
	public void ThreeSpareReturns10() {
		Frame frame = new Frame("3/");
		assertThat(frame.getBasePoints(),is(10));
	}

	@Test
	public void StrikeReturns10() {
		Frame frame = new Frame("X");
		assertThat(frame.getBasePoints(),is(10));
	}

	//Bonus Calculation
	@Test
	public void ThreeAfterSpareReturns3() {
		Frame frame = new Frame("3/");
		assertThat(frame.getBonus("3"),is(3));
	}

	@Test
	public void MissAfterSpareReturns0() {
		Frame frame = new Frame("3/");
		assertThat(frame.getBonus("-"),is(0));
	}

	@Test
	public void StrikeAfterSpareReturns10() {
		Frame frame = new Frame("3/");
		assertThat(frame.getBonus("X"),is(10));
	}

	@Test
	public void MissFourAfterStrikeReturns4() {
		Frame frame = new Frame("X");
		assertThat(frame.getBonus("-4"),is(4));
	}

	@Test
	public void StrikeStrikeAfterStrikeReturns20() {
		Frame frame = new Frame("X");
		assertThat(frame.getBonus("XX"),is(20));
	}
}
