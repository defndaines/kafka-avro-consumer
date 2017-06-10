(ns kafka-avro-consumer.core
  (:require [kafka-avro-consumer.kafka :as kafka]
            [kafka-avro-consumer.avro :as avro])
  (:gen-class))

(defn- monitor-topic [bootstrap topic]
  (let [consumer-config (merge kafka/default-consumer-config
                               {"bootstrap.servers" bootstrap})
        consumer (kafka/consumer consumer-config topic)]
    (kafka/read-topic
      consumer
      (fn [bytes] (println (str (avro/decode bytes)))))))

(defn -main
  [& args]
  (if-let [[bootstrap topic & _] args]
    (monitor-topic bootstrap topic)
    (println "Must pass bootstrap servers and topics.\n  Usage: kafka-avro-consumer <bootstrap-server:9092,bootstrap-server:9092> <topic,topic>")))
