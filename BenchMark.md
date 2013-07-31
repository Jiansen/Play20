# TAkka Play TEST

### Connection Speed from Informatic Forum to Amazon EC2 instance

$ ping -c4 176.34.229.204
PING 176.34.229.204 (176.34.229.204) 56(84) bytes of data.
64 bytes from 176.34.229.204: icmp_req=1 ttl=46 time=22.8 ms
64 bytes from 176.34.229.204: icmp_req=2 ttl=46 time=22.6 ms
64 bytes from 176.34.229.204: icmp_req=3 ttl=46 time=23.4 ms
64 bytes from 176.34.229.204: icmp_req=4 ttl=46 time=35.1 ms

--- 176.34.229.204 ping statistics ---
4 packets transmitted, 4 received, 0% packet loss, time 3004ms
rtt min/avg/max/mdev = 22.661/26.008/35.124/5.272 ms

### Connection Speed from Informatic Forum to Amazon Load Balancer

Unknown due to Amazon Security Policy.


## Throughput Summary

### command 
$ ab -kc 20 -t 60 http://IP:9000/json

<table>
    <tr>
        <td>TEST                   </td><td>AKKA Requests/sec </td><td>TAKKA Requests/sec </td><td>99% of the requests served within ms (Akka) </td><td>99% of the requests served within ms (TAkka)  </td>
        <td>Local (Desktop)        </td><td>AKKA</td><td>TAKKA</td>       
        <td>Local (EC2 T1 Micro)   </td><td>AKKA</td><td>TAKKA</td>        
        <td>1 EC2 instance         </td><td>AKKA</td><td>TAKKA</td>
        <td>2 EC2 instance         </td><td>AKKA</td><td>TAKKA</td>
        <td>4 EC2 instance         </td><td>AKKA</td><td>TAKKA</td>
        <td>8 EC2 instance         </td><td>AKKA</td><td>TAKKA</td>
        <td>16 EC2 instance        </td><td>AKKA</td><td>TAKKA</td>
        <td>32 EC2 instance        </td><td>AKKA</td><td>TAKKA</td>
        <td>64 EC2 instance        </td><td>AKKA</td><td>TAKKA</td>
        <td>128 EC2 instance       </td><td>AKKA</td><td>TAKKA</td>
    </tr>
</table>


## Detailed Results

### Throughput of local service (run on AWS)

$ ab -kc 20 -t 60 http://127.0.0.1:9000/json
This is ApacheBench, Version 2.3 <$Revision: 655654 $>
Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
Licensed to The Apache Software Foundation, http://www.apache.org/

Benchmarking 127.0.0.1 (be patient)
Completed 5000 requests
Completed 10000 requests
Completed 15000 requests
Completed 20000 requests
Completed 25000 requests
Completed 30000 requests
Completed 35000 requests
Completed 40000 requests
Completed 45000 requests
Completed 50000 requests
Finished 50000 requests


Server Software:        
Server Hostname:        127.0.0.1
Server Port:            9000

Document Path:          /json
Document Length:        26 bytes

Concurrency Level:      20
Time taken for tests:   19.749 seconds
Complete requests:      50000
Failed requests:        0
Write errors:           0
Keep-Alive requests:    50000
Total transferred:      6800000 bytes
HTML transferred:       1300000 bytes
Requests per second:    2531.80 [#/sec] (mean)
Time per request:       7.900 [ms] (mean)
Time per request:       0.395 [ms] (mean, across all concurrent requests)
Transfer rate:          336.25 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.1      0       4
Processing:     2    8   1.3      8      28
Waiting:        0    8   1.3      8      28
Total:          2    8   1.3      8      28

Percentage of the requests served within a certain time (ms)
  50%      8
  66%      8
  75%      8
  80%      9
  90%      9
  95%     10
  98%     12
  99%     13
 100%     28 (longest request)







## Throughput of AWS instance (run on desktop at IF)
$ ab -kc 20 -t 60 http://176.34.229.204:9000/json
This is ApacheBench, Version 2.3 <$Revision: 655654 $>
Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
Licensed to The Apache Software Foundation, http://www.apache.org/

Benchmarking 176.34.229.204 (be patient)
Completed 5000 requests
Completed 10000 requests
Completed 15000 requests
Completed 20000 requests
Completed 25000 requests
Completed 30000 requests
Completed 35000 requests
Completed 40000 requests
Completed 45000 requests
Completed 50000 requests
Finished 50000 requests


Server Software:        
Server Hostname:        176.34.229.204
Server Port:            9000

Document Path:          /json
Document Length:        26 bytes

Concurrency Level:      20
Time taken for tests:   57.986 seconds
Complete requests:      50000
Failed requests:        0
Write errors:           0
Keep-Alive requests:    50000
Total transferred:      6800000 bytes
HTML transferred:       1300000 bytes
Requests per second:    862.28 [#/sec] (mean)
Time per request:       23.194 [ms] (mean)
Time per request:       1.160 [ms] (mean, across all concurrent requests)
Transfer rate:          114.52 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.5      0      23
Processing:    22   23   1.1     23      50
Waiting:       22   23   1.1     23      50
Total:         22   23   1.3     23      60

Percentage of the requests served within a certain time (ms)
  50%     23
  66%     23
  75%     23
  80%     23
  90%     24
  95%     24
  98%     25
  99%     26
 100%     60 (longest request)

