# Selenoid with Go Grid Router

1. Create directory:

```
$ sudo mkdir -p /etc/grid-router/quota
```

2. Create user-access file:

```
$ sudo htpasswd -bc /etc/grid-router/users.htpasswd test test-password

```
3. Create test.xml file in the directory: `/etc/grid-router/quota`
 ````
 Note: 
  xml-file name should be the same as "username" of users.htpasswd file)
 ````
 4. Add browsers configuration to xml file:
 ```
 <qa:browsers xmlns:qa="urn:config.gridrouter.qatools.ru">
 
     <browser name="firefox" defaultVersion="59.0">
         <version number="59.0">
             <region name="1">
                 <host name="localhost" port="4445" count="10"/>
             </region>
         </version>
         <version number="58.0">
             <region name="1">
                 <host name="localhost" port="4445" count="10"/>
             </region>
         </version>
     </browser>
 
     <browser name="chrome" defaultVersion="65.0">
         <version number="65.0">
             <region name="1">
                 <host name="localhost" port="4445" count="10"/>
             </region>
         </version>
         <version number="64.0">
             <region name="1">
                 <host name="localhost" port="4445" count="10"/>
             </region>
         </version>
     </browser>
 
     <browser name="opera" defaultVersion="52.0">
         <version number="52.0">
             <region name="1">
                 <host name="localhost" port="4445" count="10"/>
             </region>
         </version>
         <version number="51.0">
             <region name="1">
                 <host name="localhost" port="4445" count="10"/>
             </region>
         </version>
     </browser>
 
 </qa:browsers>

```

5. Run the `docker-compose.yml` file to run Selenoid with GoGridRouter:
```
$ docker-compose up -d
```

6. Run your tests on remote addresss of Ggr:

```
http://test:test-password@localhost:4444/wd/hub

```