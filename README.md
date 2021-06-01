# WEB service 
### Аggregating data from several services for servicing video cameras

The [response](http://www.mocky.io/v2/5c51b9dd3400003252129fb5) for getting the list consists of objects containing the fields:
- ```id``` - camera identifier
- ```sourceDataUrl``` - link to get source data
- ```tokenDataUrl``` - link for teaching security tokens
<br/>

The format of the data in the response to the URL from the field sourceDataUrl:
- ```urlType``` - type of link to the video stream. Possible values are "LIFE" or "ARCHIVE"
- ```videoUrl``` - link to the video stream
<br/>

Data format in the response to URL from the tokenDataUrl field:
- ```value``` - security token
- ```TTL``` - token lifetime
<br/>

<details>
  <summary>Expected result of aggregation in response to HTTP request:</summary>
   
```json
[
	{
		"id": 1,
		"urlType": "LIVE",
		"videoUrl": "rtsp://127.0.0.1/1",
		"value": "fa4b588e-249b-11e9-ab14-d663bd873d93",
		"ttl": 120
	},
	{
		"id": 3,
		"urlType": "ARCHIVE",
		"videoUrl": "rtsp://127.0.0.1/3",
		"value": "fa4b5d52-249b-11e9-ab14-d663bd873d93",
		"ttl": 120
	},
	{
		"id": 20,
		"urlType": "LIVE",
		"videoUrl": "rtsp://127.0.0.1/20",
		"value": "fa4b5f64-249b-11e9-ab14-d663bd873d93",
		"ttl": 180
	},
	{
		"id": 2,
		"urlType": "ARCHIVE",
		"videoUrl": "rtsp://127.0.0.1/2",
		"value": "fa4b5b22-249b-11e9-ab14-d663bd873d93",
		"ttl": 60
	}
]

```
</details>
<br/>

Project tools:
- Spring Boot
- Hibernate
- PostgreSQL
- JUnit
- Mocito
