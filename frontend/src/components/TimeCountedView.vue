<template>

    <v-data-table
        :headers="headers"
        :items="timeCounted"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'TimeCountedView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            timeCounted : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/timeCounteds'))

            temp.data._embedded.timeCounteds.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.timeCounted = temp.data._embedded.timeCounteds;
        },
        methods: {
        }
    }
</script>

