package com.redwood.wiki.parser;

import com.redwood.wiki.utilities.ParseUtility;

public abstract class AbstractBulletParser implements Parseable {

	private static final String SPECIAL_CHAR_REG_EXPR = "[\\^$.|?*+()\\[\\]{}]";

	/**
	 * replace
	 *	[aBullet] This is bullet level1
	 *	[aBullet] This is bullet level 1
	 *		[aBullet] This is bullet level 2
	 *	[aBullet] This is bullet level 1
	 * with
	 *	[aNewBullet] This is bullet level1
	 *	[aNewBullet] This is bullet level 1
	 *  [aNewBullet][aNewBullet] This is bullet level 2
	 *	[aNewBullet] This is bullet level 1
	 */
	public String parseToTiki(String toParse) {
		String parsedBullets = "";
		String[] bullets = toParse.split("\n");
		int spaceNrIndex = 0;
		for(int i = 0 ; i < bullets.length ; i++){
			String bullet = bullets[i];
			String tikiBullets = "";
			//Count spaces of the first bullet
			// to determine the reference for the
			// other bullets.
			int bulletPosition = bullet.indexOf(getOldWikiBullet());
			if(i == 0){
				spaceNrIndex = bulletPosition;

			}
			tikiBullets = ParseUtility.charactersGenerator(bulletPosition - spaceNrIndex + 1, getTikiWikiBullet());
			parsedBullets += bullet.replaceFirst(getOldWikiBullet().replaceAll(SPECIAL_CHAR_REG_EXPR, "\\\\$0"), tikiBullets).trim() + "\n";
		}

		return parsedBullets.trim();
	}


	protected abstract String getOldWikiBullet();

	protected abstract String getTikiWikiBullet();

}
