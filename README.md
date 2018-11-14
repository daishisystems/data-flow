# data-flow

## Ontario

mvn compile exec:java -Dexec.mainClass=com.dataflow.sample.App -Dexec.args="--project=eshop-puddle --jobName=checkout-orders-dev --gcpTempLocation=gs://esw-checkout-dev/tmp/ --stagingLocation=gs://esw-checkout-dev/staging/ --region=europe-west1 --numWorkers=4 --inputTopic=projects/eshop-puddle/topics/checkout-dev --deadLetterTopic=projects/eshop-puddle/topics/checkout-dead-letter-orders-dev --sessionWindowGapDuration=20 --orderSummaryTable=eshop-puddle:checkout_dev.order_summary --orderMasterTopic=projects/eshop-puddle/topics/checkout-order-master-dev --archiveTopic=projects/eshop-puddle/topics/checkout-order-archive-dev --runner=DataflowRunner" -e

## PROD

mvn compile exec:java -Dexec.mainClass=com.dataflow.sample.App -Dexec.args="--project=project-ontario-prod --jobName=checkout-orders --gcpTempLocation=gs://esw-checkout/tmp/ --stagingLocation=gs://esw-checkout/staging/ --region=europe-west1 --numWorkers=4 --inputTopic=projects/project-ontario-prod/topics/checkout --deadLetterTopic=projects/project-ontario-prod/topics/dead-letter-orders --sessionWindowGapDuration=1200 --orderSummaryTable=project-ontario-prod:checkout.order_summary --orderMasterTopic=projects/project-ontario-prod/topics/order-master --archiveTopic=projects/project-ontario-prod/topics/order-archive --runner=DataflowRunner" -e
