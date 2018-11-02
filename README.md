# data-flow

# DEV

mvn compile exec:java -Dexec.mainClass=com.dataflow.sample.App -Dexec.args="--project=eshop-bigdata --gcpTempLocation=gs://dataflow-orders/temp/ --stagingLocation=gs://dataflow-orders/staging/ --region=europe-west1 --numWorkers=4 --runner=DataflowRunner" -e

# Ontario

mvn compile exec:java -Dexec.mainClass=com.dataflow.sample.App -Dexec.args="--project=eshop-puddle --gcpTempLocation=gs://esw-checkout-dev/tmp/ --stagingLocation=gs://esw-checkout-dev/staging/ --region=europe-west1 --numWorkers=4 --runner=DataflowRunner" -e

# PROD

mvn compile exec:java -Dexec.mainClass=com.dataflow.sample.App -Dexec.args="--project=project-ontario-prod --gcpTempLocation=gs://esw-checkout/tmp/ --stagingLocation=gs://esw-checkout/staging/ --region=europe-west1 --numWorkers=4 --runner=DataflowRunner" -e
