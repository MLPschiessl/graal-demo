# 



Die Tests wurden mit dem Tool [k6.io](https://k6.io/) geschrieben. Die Anleitung zur Installation ist [hier](https://k6.io/docs/get-started/installation/) dokumentiert.

Getestet wurden die Last-Tests unter der WSL2 in der Version 1.2.5.0 mit Ubuntu 22.04.2 LTS

## Ausführen

```bash
k6 run spike_test.js -e BASE_URL=http://localhost:8080
```
