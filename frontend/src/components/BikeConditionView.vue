<template>

    <v-data-table
        :headers="headers"
        :items="bikeCondition"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'BikeConditionView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "rentCount", value: "rentCount" },
                { text: "availableRent", value: "availableRent" },
            ],
            bikeCondition : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/bikeConditions'))

            temp.data._embedded.bikeConditions.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.bikeCondition = temp.data._embedded.bikeConditions;
        },
        methods: {
        }
    }
</script>

