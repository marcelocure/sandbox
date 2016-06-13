var bands = 
{
    get: {
            request: {},
            response: {
            bands: [
                {
                    id: "ab702fc4-467d-4cc6-8ba9-e1d283bc4a33",
                    name: "AC/DC"
                },{
                    id: "32398b1e-53d8-4c0a-99c0-2c7567b900e7",
                    name: "Beatles"
                }
            ]
        }
    },
    post: {
            request: {
                bands: [
                    {
                        name: "Rush"
                    }
                ]
            },
            response: {
                bands: [
                    {
                        id: "4e0ce5b5-8ff9-4a32-b38a-4dbfbc50faea",
                        name: "Rush"
                    }
                ]
            }
    }
}
module.exports = bands;