coinpayments-java
========

[![Apache License](http://img.shields.io/badge/license-ASL-blue.svg)](https://github.com/brunocvcunha/coinpayments-java/blob/master/LICENSE)
[![Build Status](https://travis-ci.org/brunocvcunha/coinpayments-java.svg)](https://travis-ci.org/brunocvcunha/coinpayments-java)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.brunocvcunha.coinpayments/coinpayments-java/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.brunocvcunha.coinpayments/coinpayments-java)
[![Code Climate](https://codeclimate.com/github/brunocvcunha/coinpayments-java/badges/gpa.svg)](https://codeclimate.com/github/brunocvcunha/coinpayments-java)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)](http://makeapullrequest.com)

:movie_camera: coinpayments-java - Java Wrapper for CoinPayments.net


Usage
--------

Download [the latest release JAR][1] or grab via Maven:
```xml
<dependency>
  <groupId>org.brunocvcunha.coinpayments</groupId>
  <artifactId>coinpayments-java</artifactId>
  <version>1.3</version>
</dependency>
```
or Gradle:
```groovy
compile 'org.brunocvcunha.coinpayments:coinpayments-java:1.3'
```



Supported Operations & Examples
--------

#### Initialize

```java
CoinPayments api = CoinPayments.builder()
        .publicKey("<publicKey>")
        .privateKey("<privateKey>")
        .client(HttpClients.createDefault()).build();

ResponseWrapper<BasicInfoResponse> accountInfo = api.sendRequest(new CoinPaymentsBasicAccountInfoRequest());
log.info("Account: " + accountInfo.getResult());

```

#### Create Transaction

```java
ResponseWrapper<CreateTransactionResponse> txResponse = api.sendRequest(CoinPaymentsCreateTransactionRequest.builder().amount(10)
        .currencyPrice("USD")
        .currencyTransfer("LTC")
        .callbackUrl("<callback-url-if-wanted>")
        .custom("Order XYZ")
        .build());
log.info(txResponse.getResult().getTransactionId() + " - " + txResponse.getResult().getStatusUrl());

```


**Do you like this project? Support it by donating**

- ![btc](https://raw.githubusercontent.com/reek/anti-adblock-killer/gh-pages/images/bitcoin.png) Bitcoin: 3EN9KCzKunc1PQppBXUSa8UCBoncMXii5C


Snapshots of the development version are available in [Sonatype's `snapshots` repository][snap].

coinpayments-java requires at minimum Java 8.


 [1]: https://search.maven.org/remote_content?g=org.brunocvcunha.coinpayments&a=coinpayments-java&v=LATEST
 [snap]: https://oss.sonatype.org/content/repositories/snapshots/
