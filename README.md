# data-flow

## Ontario

mvn compile exec:java -Dexec.mainClass=com.dataflow.sample.App -Dexec.args="--project=eshop-puddle --jobName=checkout-orders-dev --update --gcpTempLocation=gs://esw-checkout-dev/tmp/ --stagingLocation=gs://esw-checkout-dev/staging/ --region=europe-west1 --numWorkers=4 --inputTopic=projects/eshop-puddle/topics/checkout-dev --deadLetterTopic=projects/eshop-puddle/topics/checkout-dead-letter-orders-dev --sessionWindowGapDuration=20 --orderSummaryTable=eshop-puddle:checkout_dev.order_summary --orderMasterTopic=projects/eshop-puddle/topics/checkout-order-master-dev --archiveTopic=projects/eshop-puddle/topics/checkout-order-archive-dev --deviceAtlasTopic=projects/eshop-puddle/topics/device-atlas-dev --runner=DataflowRunner" -e

mvn compile exec:java -Dexec.mainClass=com.dataflow.sample.Payments -Dexec.args="--project=eshop-puddle --jobName=payments-dev --gcpTempLocation=gs://esw-checkout-dev/tmp/ --stagingLocation=gs://esw-checkout-dev/staging/ --region=europe-west1 --numWorkers=4 --inputTopic=projects/eshop-puddle/topics/payments-dev --deadLetterTopic=projects/eshop-puddle/topics/payments-dead-letter-dev --paymentMasterTopic=projects/eshop-puddle/topics/payments-master-dev --runner=DataflowRunner" -e

## PROD

mvn compile exec:java -Dexec.mainClass=com.dataflow.sample.App -Dexec.args="--project=project-ontario-prod --jobName=checkout-orders --update --gcpTempLocation=gs://esw-checkout/tmp/ --stagingLocation=gs://esw-checkout/staging/ --region=europe-west1 --numWorkers=4 --inputTopic=projects/project-ontario-prod/topics/checkout --deadLetterTopic=projects/project-ontario-prod/topics/dead-letter-orders --sessionWindowGapDuration=1200 --orderSummaryTable=project-ontario-prod:checkout.order_summary --orderMasterTopic=projects/project-ontario-prod/topics/order-master --archiveTopic=projects/project-ontario-prod/topics/order-archive --deviceAtlasTopic=projects/project-ontario-prod/topics/device-atlas --runner=DataflowRunner" -e

mvn compile exec:java -Dexec.mainClass=com.dataflow.sample.Payments -Dexec.args="--project=project-ontario-prod --jobName=payments --gcpTempLocation=gs://esw-payments/tmp/ --stagingLocation=gs://esw-payments/staging/ --region=europe-west1 --numWorkers=4 --inputTopic=projects/project-ontario-prod/topics/payments --deadLetterTopic=projects/project-ontario-prod/topics/payments-dead-letter --paymentMasterTopic=projects/project-ontario-prod/topics/payments-master --runner=DataflowRunner" -e
