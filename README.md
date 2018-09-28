# data-flow
Execute Pipeline:
mvn compile exec:java -Dexec.mainClass=com.dataflow.sample.App -Dexec.args="--project=eshop-bigdata --gcpTempLocation=gs://dataflow-orders/temp/ --stagingLocation=gs://dataflow-orders/staging/ --runner=DataflowRunner" -e