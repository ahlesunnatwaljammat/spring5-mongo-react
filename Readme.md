After migrating to jdk9, getting Caused by: java.lang.NoClassDefFoundError: javax/xml/bind/JAXBException
=================================
solution:
https://www.concretepage.com/forum/thread?qid=531
Added jaxb dependency in pom.xml, because of its deprecation in jdk 9

<dependency>
    <groupId>javax.xml.bind</groupId>
    <artifactId>jaxb-api</artifactId>
    <version>2.3.0</version>
</dependency>

