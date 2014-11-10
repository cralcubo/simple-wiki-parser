package com.redwood.wiki.parser;



public class BulletsParser extends AbstractBulletParser {
	private static final String BULLETS_REG_EXPR = "([\\s]*\\*.+\n*){1,}";

	private static final String TIKI_BULLET = "*";
	private static final String OLD_WIKI_BULLET = "*";

	public String getRegExpr() {
		return BULLETS_REG_EXPR;
	}

	@Override
	protected String getOldWikiBullet() {
		return OLD_WIKI_BULLET;
	}

	@Override
	protected String getTikiWikiBullet() {
		return TIKI_BULLET;
	}

}
