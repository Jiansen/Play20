# TAkka Play TEST

### Connection Speed

Ping to localhost

<pre><code>
$ ping -c4 176.34.229.204
ping -c4 localhost
PING localhost (127.0.0.1) 56(84) bytes of data.
64 bytes from localhost (127.0.0.1): icmp_req=1 ttl=64 time=0.027 ms
64 bytes from localhost (127.0.0.1): icmp_req=2 ttl=64 time=0.020 ms
64 bytes from localhost (127.0.0.1): icmp_req=3 ttl=64 time=0.025 ms
64 bytes from localhost (127.0.0.1): icmp_req=4 ttl=64 time=0.028 ms

--- localhost ping statistics ---
4 packets transmitted, 4 received, 0% packet loss, time 2997ms
rtt min/avg/max/mdev = 0.020/0.025/0.028/0.003 ms
</code></pre>



Ping from Informatic Forum to Amazon EC2 instance

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


Ping from from Informatic Forum to Amazon Load Balancer

Unknown due to Amazon Security Policy.






## Throughput Summary

### multi-siege.sh

<pre><code>

for i in {1..1200}
do
   (siege -b -c1 -r 500 IP:9000/json) &
done
wait

</code></pre>



$ siege -b -c100 -t5m IP:9000/json

$ siege -b -c100 -t5m IP:8888/json


NOTES: 
1. ApacheBenchmar and others are not appropriate because DNS need to be resolved each time.
2. After set up the load balancer, run siege for 1 minute to make sure all EC2 instances are "warmed up"
3. Multiple benchmarking clients are quired, see pitfall below.
4. The number of clients (1200), and the number of EC2 instances are picked because: 
   - ping to localhost is 1000X faster than ping to EC2 instance.
   - if number of clients is lower than 70, the throughput is roughly 20 trans/sec·client.
   - when the number of clients is set to 140, the throughput is  13.09 trans/sec·client, almost doubled.
   - therefore, 70 clients make the most of a signle EC2 client and the network connections.
   - to fully use 16 EC2 instances, we need 70x16 = 1120 clients.  But the connection speed is bound (1000x).

Pitfall:
If we run benchmark in a client only, for the Play example, the throughput will always be about 20 trans/sec X concurrenct requests, no matter how many EC2 instances are used.
Because the throughtput is bound by the network connection.


### results

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
        <td>1 EC2 instance         </td><td>1.96</td><td>2.05</td></td><td>2.32</td><td>2.51</td>
    <tr>
    </tr>        
        <td>2 EC2 instance         </td><td>2.92</td><td>2.88</td></td><td>3.88</td><td>3.92</td>
    <tr>
    </tr>        
        <td>4 EC2 instance         </td><td>3.84</td><td>3.56</td></td><td>4.21</td><td>4.54</td>
    <tr>
    </tr>        
        <td>8 EC2 instance         </td><td>7.68</td><td>7.81</td></td><td>8.28</td><td>8.06</td>
    <tr>
    </tr>        
        <td>16 EC2 instance        </td><td>15.26</td><td>14.67</td></td><td>15.84</td><td>15.77</td>
    <tr>
</table>







