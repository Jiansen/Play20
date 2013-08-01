# TAkka Play TEST

### Connection Speed from Informatic Forum to Amazon EC2 instance

<pre><code>
$ ping -c4 176.34.229.204
PING 176.34.229.204 (176.34.229.204) 56(84) bytes of data.
64 bytes from 176.34.229.204: icmp_req=1 ttl=46 time=22.8 ms
64 bytes from 176.34.229.204: icmp_req=2 ttl=46 time=22.6 ms
64 bytes from 176.34.229.204: icmp_req=3 ttl=46 time=23.4 ms
64 bytes from 176.34.229.204: icmp_req=4 ttl=46 time=35.1 ms

--- 176.34.229.204 ping statistics ---
4 packets transmitted, 4 received, 0% packet loss, time 3004ms
rtt min/avg/max/mdev = 22.661/26.008/35.124/5.272 ms
</code></pre>


### Connection Speed from Informatic Forum to Amazon Load Balancer

Unknown due to Amazon Security Policy.


## Throughput Summary

### command 
$ siege -b -c100 -t5m IP:9000/json

$ siege -b -c100 -t5m IP:8888/json


NOTES: 
1. ApacheBenchmar and others are not appropriate because DNS need to be resolved each time.
2. The benchmark should be run for a few minutes so that ELB will increase the number of instances.


### result

<table>
    <tr>
        <td>TEST                   </td><td>AKKA Play trans/sec </td><td>TAKKA Play trans/sec </td>td>AKKA Socko trans/sec </td><td>TAKKA Socko trans/sec </td>
    <tr>
    </tr>        
        <td>Local (Desktop)        </td><td>AKKA</td><td>TAKKA</td>       
    <tr>
    </tr>        
        <td>Local (EC2 T1 Micro)   </td><td>AKKA</td><td>TAKKA</td>        
    <tr>
    </tr>        
        <td>1 EC2 instance         </td><td>AKKA</td><td>TAKKA</td>
    <tr>
    </tr>        
        <td>2 EC2 instance         </td><td>AKKA</td><td>TAKKA</td>
    <tr>
    </tr>        
        <td>4 EC2 instance         </td><td>AKKA</td><td>TAKKA</td>
    <tr>
    </tr>        
        <td>8 EC2 instance         </td><td>AKKA</td><td>TAKKA</td>
    <tr>
    </tr>        
        <td>16 EC2 instance        </td><td>AKKA</td><td>TAKKA</td>
    <tr>
    </tr>        
        <td>32 EC2 instance        </td><td>AKKA</td><td>TAKKA</td>
    <tr>
</table>


## Detailed Results

### Local (Desktop)

#### Akkka
<pre><code>
</code></pre>

### TAkka

<pre><code>
</code></pre>

## Local (EC2 T1 Micro)

### Akka
<pre><code>
</code></pre>



### TAkka

<pre><code>
</code></pre>


## 1 EC2 instance

### Akka
<pre><code>

</code></pre>

### TAkka

<pre><code>
</code></pre>

## 4 EC2 instance

### Akka
<pre><code>

$ siege -b -c100 -t3m AkkaPlay-488630556.eu-west-1.elb.amazonaws.com:9000/json** SIEGE 2.70
** Preparing 100 concurrent users for battle.
The server is now under siege...
Lifting the server siege...      done.
Transactions:		      109296 hits
Availability:		      100.00 %
Elapsed time:		      179.85 secs
Data transferred:	        2.71 MB
Response time:		        0.16 secs
Transaction rate:	      607.71 trans/sec
Throughput:		        0.02 MB/sec
Concurrency:		       99.83
Successful transactions:      109296
Failed transactions:	           0
Longest transaction:	        5.13
Shortest transaction:	        0.04
 
FILE: /var/log/siege.log
You can disable this annoying message by editing
the .siegerc file in your home directory; change
the directive 'show-logfile' to false.
[error] unable to create log file: Permission denied

</code></pre>

### TAkka
<pre><code>
</code></pre>

## 8 EC2 instance

### Akka
<pre><code>
$ siege -b -c100 -t3m AkkaPlay-488630556.eu-west-1.elb.amazonaws.com:9000/json
** SIEGE 2.70
** Preparing 100 concurrent users for battle.
The server is now under siege...
Lifting the server siege...      done.
Transactions:		      109667 hits
Availability:		      100.00 %
Elapsed time:		      179.57 secs
Data transferred:	        2.72 MB
Response time:		        0.16 secs
Transaction rate:	      610.72 trans/sec
Throughput:		        0.02 MB/sec
Concurrency:		       99.84
Successful transactions:      109667
Failed transactions:	           0
Longest transaction:	        7.10
Shortest transaction:	        0.04


</code></pre>

### TAkka
<pre><code>
</code></pre>

## 16 EC2 instance

### Akka
<pre><code>

siege -b -c100 -t1m AkkaPlay-488630556.eu-west-1.elb.amazonaws.com:9000/json
** SIEGE 2.70
** Preparing 100 concurrent users for battle.
The server is now under siege...
Lifting the server siege...      done.
Transactions:		       35887 hits
Availability:		      100.00 %
Elapsed time:		       59.76 secs
Data transferred:	        0.89 MB
Response time:		        0.17 secs
Transaction rate:	      600.52 trans/sec
Throughput:		        0.01 MB/sec
Concurrency:		       99.19
Successful transactions:       35887
Failed transactions:	           0
Longest transaction:	        5.24
Shortest transaction:	        0.04

</code></pre>

### TAkka
<pre><code>
</code></pre>







