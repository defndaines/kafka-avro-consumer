# Kafka Avro Consumer

This is a stripped skeleton project, which consumes Avro from Kafka.
To make it work, code has to be changed to identify the Avro schema.

When run, the consumer will read from the topic until the
application is killed (e.g., CTRL-C).

The Kafka group ID is hard-coded, so re-running the application will not re-read
any messages which have already been acked with Kafka. The application only
acknowledges batches after they have been handled. In the current
implementation, the handler parses the Avro object and then prints
it to STDOUT as JSON.


## Usage

To run from the command line and output records to STDOUT.

    $ java -jar kafka-avro-consumer-0.1.0-standalone.jar <bootstrap-server:9092> <topics>


## License

Copyright © 2017 Michael S. Daines

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
