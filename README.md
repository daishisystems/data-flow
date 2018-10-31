# data-flow

DEV
=====

mvn compile exec:java -Dexec.mainClass=com.dataflow.sample.App -Dexec.args="--project=eshop-bigdata --gcpTempLocation=gs://dataflow-orders/temp/ --stagingLocation=gs://dataflow-orders/staging/ --runner=DataflowRunner" -e

Ontario
=====

mvn compile exec:java -Dexec.mainClass=com.dataflow.sample.App -Dexec.args="--project=eshop-puddle --gcpTempLocation=gs://esw-checkout-dev/tmp/ --stagingLocation=gs://esw-checkout-dev/staging/ --runner=DataflowRunner" -e