# ip-whitelist

Run this repo by gradle bootRun

Use this ednpoint to add or update data

http://localhost:8080/api/v1/ip-whitelist
Method: POST

Sample request body
`
{
  "id": null,
  "ipAddress": "80.94.29.13",
  "environment": "Dev",
  "appName": "Spring boot app",
  "active": true
}
`

Use this endpoint to filter data

http://localhost:8080/api/v1/ip-whitelist/whitelists
Method: GET

Sample requet body

`
{
  "id": [null],
  "ipAddress": ["80.94.29.13"],
  "environment": ["Dev"],
  "appName": ["Spring boot app"],
  "active": [true]
}
`
