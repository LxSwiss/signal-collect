/*
 *  @author Philip Stutz
 *  
 *  Copyright 2011 University of Zurich
 *      
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  
 *         http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  
 */

package signalcollect.api

import signalcollect.interfaces._

case class ExecutionInformation(
  computeGraphConfiguration: Configuration,
  executionParameters: ExecutionParameters,
  executionStatistics: ExecutionStatistics,
  aggregatedWorkerStatistics: WorkerStatistics,
  individualWorkerStatistics: List[WorkerStatistics]) {

  override def toString: String = {
    "\n----------\n" +
    "Configuration\n" +
      "----------\n" +
      computeGraphConfiguration.toString +
      "\n----------\n" +
    "Parameters\n" +
      "----------\n" +
      executionParameters.toString +
      "\n----------\n" +
      "Statistics\n" +
      "----------\n" +
    executionStatistics.toString + "\n"
  }
}

case class ExecutionStatistics(
  signalSteps: Long,
  collectSteps: Long,
  computationTimeInMilliseconds: Long,
  jvmCpuTimeInMilliseconds: Long,
  graphLoadingWaitInMilliseconds: Long) {
  
    override def toString: String = {
      "# signal steps" + "\t" + "\t" + signalSteps  + "\n" + 
      "# collect steps" + "\t" + "\t" + collectSteps  + "\n" +
      "computation time (ms)" + "\t" + computationTimeInMilliseconds  + "\n" +
      "JVM CPU time (ms)" + "\t" + jvmCpuTimeInMilliseconds  + "\n" +
      "graph loading time (ms)" + "\t" + graphLoadingWaitInMilliseconds
    }
}