/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Psi Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Psi
 * 
 * Psi is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 * 
 * File Created @ [18/01/2016, 19:29:43 (GMT)]
 */
package vazkii.psi.common.spell.operator.number;

import vazkii.psi.api.spell.Spell;
import vazkii.psi.api.spell.SpellContext;
import vazkii.psi.api.spell.SpellParam;
import vazkii.psi.api.spell.SpellPiece;
import vazkii.psi.api.spell.SpellRuntimeException;
import vazkii.psi.api.spell.param.ParamNumber;
import vazkii.psi.api.spell.piece.PieceOperator;

public class PieceOperatorInverse extends PieceOperator {

	SpellParam num;
	
	public PieceOperatorInverse(Spell spell) {
		super(spell);
	}
	
	@Override
	public void initParams() {
		addParam(num = new ParamNumber(SpellParam.GENERIC_NAME_TARGET, SpellParam.BLUE, false, false));
	}
	
	@Override
	public Object execute(SpellContext context) throws SpellRuntimeException {
		Double d = this.<Double>getParamValue(context, num);

		if(d == 0)
			throw new SpellRuntimeException("dividebyzero");
		
		return 1.0 / d;
	}
	
	@Override
	public Class<?> getEvaluationType() {
		return Double.class;
	}

}
