/*
 * Software License Agreement (BSD License)
 *
 * Copyright 2013 Marc Pujol <mpujol@iiia.csic.es>.
 *
 * Redistribution and use of this software in source and binary forms, with or
 * without modification, are permitted provided that the following conditions
 * are met:
 *
 *   Redistributions of source code must retain the above
 *   copyright notice, this list of conditions and the
 *   following disclaimer.
 *
 *   Redistributions in binary form must reproduce the above
 *   copyright notice, this list of conditions and the
 *   following disclaimer in the documentation and/or other
 *   materials provided with the distribution.
 *
 *   Neither the name of IIIA-CSIC, Artificial Intelligence Research Institute
 *   nor the names of its contributors may be used to
 *   endorse or promote products derived from this
 *   software without specific prior written permission of
 *   IIIA-CSIC, Artificial Intelligence Research Institute
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package es.csic.iiia.maxsum.factors.cardinality;

/**
 * Workload function that enforces no more than <em>k</em> variables to be
 * active at the same time.
 *
 * @author Marc Pujol <mpujol@iiia.csic.es>
 */
public class MaxAgFunction implements CardinalityFunction {

    private final int maxActiveVariables;

    private double utility;

    /**
     * Builds a new MaxAgFunction that prevents more than the given maximum
     * number of variables to be active at the same time, by introducing the
     * specified amount of utility/cost whenever the constraint is violated.
     *
     * @param maxActiveVariables maximum number of active variables.
     * @param utility amount of utility/cost to introduce.
     */
    public MaxAgFunction(int maxActiveVariables, double utility) {
        this.maxActiveVariables = maxActiveVariables;
        this.utility = utility;
    }

    /**
     * Get the cost of activating the given number of variables.
     *
     * @param numActiveVariables number of variables to activate.
     * @return Infinity if the given number of variables is above the maximum
     * allowable, or 0 otherwise.
     */
    @Override
    public double getCost(int numActiveVariables) {
        if (numActiveVariables > maxActiveVariables) {
            return utility;
        }
        return 0;
    }

}
