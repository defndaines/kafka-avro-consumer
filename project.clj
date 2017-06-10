(defproject kafka-avro-consumer "0.2.0-SNAPSHOT"
  :description "Consumes Avro data from Kafka"
  :url "https://github.com/defndaines/kafka-avro-consumer"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0-alpha14"]
                 [org.apache.kafka/kafka_2.11 "0.9.0.1"]
                 [org.apache.kafka/kafka-clients "0.9.0.1"]]
  :main ^:skip-aot kafka-avro-consumer.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
