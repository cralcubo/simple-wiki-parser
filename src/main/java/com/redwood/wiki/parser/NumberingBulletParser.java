package com.redwood.wiki.parser;

public class NumberingBulletParser extends AbstractBulletParser {

	private static final String NUMB_BULLET_REG_EXPR = "(^[\\s]*1\\..+\n*){1,}";
	private static final String TIKI_NUMB_BULLET = "#";
	private static final String OLD_NUMB_BULLET = "1.";


	public String getRegExpr() {
		return NUMB_BULLET_REG_EXPR;
	}

	@Override
	protected String getOldWikiBullet() {
		return OLD_NUMB_BULLET;
	}

	@Override
	protected String getTikiWikiBullet() {
		return TIKI_NUMB_BULLET;
	}

}
