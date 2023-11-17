import http from 'k6/http';
import { sleep, check } from 'k6';
import { Trend, Counter } from 'k6/metrics';

const baseUrl = `${__ENV.BASE_URL}`;

export let options = {
    scenarios: {
        listAuthors: {
            executor: 'ramping-arrival-rate',
            exec: 'listAuthors',
            preAllocatedVUs: 15,
            timeUnit: "1m",
            stages: [
                { target: 100, duration: '20s'},
                { target: 3000, duration: '10s' },
                { target: 3000, duration: '5m' }
            ]
        }
    }
};

export function listAuthors() {
    const res =  http.get(`${baseUrl}/authors`);
    check(res, {
        'is status 200': (r) => r.status === 200,
    });
}


export default function () {
}