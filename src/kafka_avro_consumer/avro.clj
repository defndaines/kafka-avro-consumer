(ns kafka-avro-consumer.avro
  (:import [org.apache.avro.io DecoderFactory]
           [org.apache.avro.specific SpecificDatumReader]))

;; TODO Need to import and identify actual scham here:
(def ^:private schema FakeKafkaAvro/SCHEMA$)

(def ^:private avro-reader (SpecificDatumReader. schema))

(def ^:private decoder-factory (org.apache.avro.io.DecoderFactory/get))

(def ^:private binary-decoder (atom nil))

(defn- decoder-for [bytes]
  (swap! binary-decoder
         (fn [decoder] (.binaryDecoder decoder-factory bytes decoder))))

(defn decode [bytes]
  (.read avro-reader nil (decoder-for bytes)))
