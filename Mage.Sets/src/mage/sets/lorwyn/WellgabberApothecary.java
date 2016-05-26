/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */
package mage.sets.lorwyn;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.common.PreventDamageToTargetEffect;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.Rarity;
import mage.constants.Zone;
import mage.filter.common.FilterCreaturePermanent;
import mage.filter.predicate.Predicates;
import mage.filter.predicate.mageobject.SubtypePredicate;
import mage.filter.predicate.permanent.TappedPredicate;
import mage.target.common.TargetCreaturePermanent;

/**
 *
 * @author Styxo
 */
public class WellgabberApothecary extends CardImpl {

    private static final FilterCreaturePermanent filter = new FilterCreaturePermanent("target tapped Merfolk or Kithkin creature this turn");

    static {
        filter.add(new TappedPredicate());
        filter.add(Predicates.or(new SubtypePredicate("Merfolk"), new SubtypePredicate("Kithkin")));
    }

    public WellgabberApothecary(UUID ownerId) {
        super(ownerId, 47, "Wellgabber Apothecary", Rarity.COMMON, new CardType[]{CardType.CREATURE}, "{4}{W}");
        this.expansionSetCode = "LRW";
        this.subtype.add("Merfolk");
        this.subtype.add("Cleric");

        this.power = new MageInt(2);
        this.toughness = new MageInt(3);

        // {1}{W} : Prevent all damage that would be dealt to target tapped Merfolk or Kithkin creatuer this turn
        SimpleActivatedAbility ability = new SimpleActivatedAbility(Zone.BATTLEFIELD, new PreventDamageToTargetEffect(Duration.EndOfTurn, Integer.MAX_VALUE), new ManaCostsImpl("{1}{W}"));
        ability.addTarget(new TargetCreaturePermanent(filter));
        this.addAbility(ability);

    }

    public WellgabberApothecary(final WellgabberApothecary card) {
        super(card);
    }

    @Override
    public WellgabberApothecary copy() {
        return new WellgabberApothecary(this);
    }
}