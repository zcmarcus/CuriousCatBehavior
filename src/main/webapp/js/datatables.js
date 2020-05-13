const initializeDataTables = () => {

    $('#postsTable').DataTable( {
        "searching": false,
        "info":     false,
        "pagingType": "full",
        "lengthChange": false,
        "order": [[4, "desc" ]],
        "columnDefs": [
            {
                "targets": [ 2 ],
                "orderData" : 4
            },
            {
                "targets": [ 4 ],
                "className" : 'hiddenColumn'
            },
            {
                "targets": [ 6 ],
                "className": 'hiddenColumn'
            }
        ],
        "lengthMenu": [[10], [10]]
    });

    // $('#tagsTable').DataTable( {
    //     "searching": false,
    //     "ordering": false,
    //     "info":     false,
    //     "paging":   false,
    //     "lengthChange": false,
    // });

    // make entire rows clickable
    $('#postsTable tbody').on('click', 'tr', function () {
        let href = $(this).find('a').prop('href');
        if(href) {
            window.location = href;
        }
    });
}